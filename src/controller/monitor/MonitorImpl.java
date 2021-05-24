package controller.monitor;

import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

import controller.GameStatus;
import controller.GameViewController;

public class MonitorImpl implements ViewMonitor, ControllerMonitor {

	private final ReentrantLock lock;

	private Optional<GameStatus> gameState;
	private GameViewController ctrl;

	public MonitorImpl(GameViewController c) {
		this.ctrl = c;
		this.lock = new ReentrantLock();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void pause(){
		this.lock.lock();
		try{
			if(!this.gameState.get().equals(GameStatus.PAUSED) 
					&& !this.gameState.get().equals(GameStatus.STOPPED)) {
				this.gameState = Optional.of(GameStatus.PAUSED);
				this.ctrl.stop();
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
			if(this.gameState.get().equals(GameStatus.PAUSED) 
					&& !this.gameState.get().equals(GameStatus.STOPPED)) {
				this.gameState = Optional.of(GameStatus.RESUMED);
				this.ctrl.resume();
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
	public void restart() {
		this.lock.lock();
		try{
			if(this.gameState.get().equals(GameStatus.PAUSED) 
					&& !this.gameState.get().equals(GameStatus.STOPPED)) {
				this.gameState = Optional.of(GameStatus.RESTARTED);
				this.ctrl.restart();
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
            if(!this.gameState.get().equals(GameStatus.STOPPED)){
            	this.gameState = Optional.of(GameStatus.STOPPED);
				this.ctrl.stop();
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
    public void setResume() {
    	this.lock.lock();
    	try {
    		this.gameState = Optional.of(GameStatus.RUNNING);
    	}
    	finally {
    		this.lock.unlock();
    	}
    }

    /**
   	 * {@inheritDoc}
   	 */
	@Override
	public void setStart() {
		this.lock.lock();
    	try {
    		this.gameState = Optional.of(GameStatus.RUNNING);
    	}
    	finally {
    		this.lock.unlock();
    	}
	}
}
