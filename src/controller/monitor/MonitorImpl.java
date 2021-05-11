package controller.monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import controller.GameStatus;

public class MonitorImpl implements ViewMonitor, ControllerMonitor {

	private final ReentrantLock lock;
	private final Condition condition;

	private GameStatus gameState;

	public MonitorImpl() {
		this.lock = new ReentrantLock();
		this.condition = this.lock.newCondition();
		this.gameState = GameStatus.RUNNING;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void pause(){
		this.lock.lock();
		try{
			if(!this.gameState.equals(GameStatus.PAUSED) && !this.gameState.equals(GameStatus.STOPPED)) {
				this.gameState = GameStatus.PAUSED;
			}
		}
		finally {
			this.lock.unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resume(){
		this.lock.lock();
		try{
			if(this.gameState.equals(GameStatus.PAUSED) && !this.gameState.equals(GameStatus.STOPPED)) {
				this.gameState = GameStatus.RESUMED;
				this.condition.signalAll();	
			}
		}
		finally {
			this.lock.unlock();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isGamePaused() {
		 this.lock.lock();
	     try {
	    	 while (this.gameState.equals(GameStatus.PAUSED) && !this.gameState.equals(GameStatus.STOPPED)) {
	    		 try {
	    			 this.condition.await();
	             } 
	             catch (InterruptedException ignored) {}
	        }
	     }
	     finally {
	    	 this.lock.unlock();
	     }
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stop(){
        this.lock.lock();
        try{
            if(!this.gameState.equals(GameStatus.STOPPED)){
            	this.gameState = GameStatus.STOPPED;
            }
        }
        finally {
            this.lock.unlock();
        }
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
	public boolean isGameStopped(){
        this.lock.lock();
        try{
            return this.gameState.equals(GameStatus.STOPPED);
        }
        finally {
            this.lock.unlock();
        }
    }

    /**
	 * {@inheritDoc}
	 */
    @Override
    public boolean isGameResumed() {
    	this.lock.lock();
    	try {
    		return this.gameState.equals(GameStatus.RESUMED);
    	}
    	finally {
    		this.lock.unlock();
    	}
    }

    /**
	 * {@inheritDoc}
	 */
    @Override
    public void setResume() {
    	this.lock.lock();
    	try {
    		this.gameState = GameStatus.RUNNING;
    	}
    	finally {
    		this.lock.unlock();
    	}
    }	
}
