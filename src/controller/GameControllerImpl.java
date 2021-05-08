package controller;

import java.util.Optional;

import controller.monitor.ControllerMonitor;
import controller.monitor.MonitorImpl;

/**
 * Implementation of {@link GameController}
 */
public class GameControllerImpl implements GameController{

	private final int FPS = 60;
	private final double FRAME_PERIOD = 1000000000 / FPS;
	private Optional<Thread> timer;
	private ControllerMonitor monitor;

	/**
	 * Implementation of {@link GameController}
	 */
	public GameControllerImpl() {
		this.monitor = new MonitorImpl();
		this.timer = Optional.empty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startNewGame() {
		if(!this.isRunning()) {
			this.timer = Optional.of(new Timer());
			this.timer.get().start();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopGameLoop() {
		if(this.isRunning()) {
			try {
				this.timer.get().join();
				this.timer = Optional.empty();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isRunning() {
		return !this.timer.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void gameOver() {
		this.stopGameLoop();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void victory() {
		this.stopGameLoop();
	}

	/**
	 * Update {@link GenericEntity}s position
	 */
	private void updateGame() {
		//this.model.update();	//Update entities's position
	}

	/**
	 * Update {@link GenericEntity}s graphics
	 */
	private void render() {
		
	}

	/**
	 * Thread for the game loop
	 */
	private class Timer extends Thread{
	
		private final int SLEEP_TIME = 5;	//waiting time between 2 loop cycles: 5 ms
		private long lastTime;

		public void run() {
			lastTime = System.nanoTime();		
			double delta = 0;
			while(isRunning() && !monitor.isGameStopped()) {
				long current = System.nanoTime();
				monitor.isGamePaused();
				this.isResumed();
				delta += (current - lastTime) / FRAME_PERIOD;
				lastTime = current;
				if(delta >= 1) {
					updateGame();
					render();
					delta--;
				}
				try {
					Thread.sleep(this.SLEEP_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			stopGameLoop();
		}

		private void isResumed() {
			if(monitor.isGameResumed()) {
				this.lastTime = System.nanoTime();
				monitor.setResume();
			}
		}
	}
}
