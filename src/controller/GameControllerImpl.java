package controller;

import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import controller.monitor.ControllerMonitor;
import controller.monitor.MonitorImpl;

/**
 * Implementation of {@link GameController}
 */
public class GameControllerImpl implements GameController, GameViewController {

	private final int FPS = 60;
	private final int DEL = 1000/FPS;
	private final int TIME_TO_RESUME = 3000;
	private Optional<ScheduledExecutorService> timer;
	private ControllerMonitor monitor;

	/**
	 * Implementation of {@link GameController}
	 */
	public GameControllerImpl() {
		this.monitor = new MonitorImpl(this);
		//
		this.timer = Optional.empty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startNewGame() {
		if(!this.isRunning()) {
			//
			this.monitor.setStart();
			this.timer = Optional.ofNullable(this.createTimer(DEL));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stop() {
		if(this.timer.isPresent()) {
			this.timer.get().shutdownNow();
			this.timer = Optional.empty();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resume() {
		this.timer = Optional.ofNullable(this.createTimer(TIME_TO_RESUME));
		this.monitor.setResume();		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void restart() {
		this.timer = Optional.ofNullable(this.createTimer(DEL));
		this.monitor.setResume();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isRunning() {
		return this.timer.isPresent() && !timer.get().isTerminated() 
				&& !timer.get().isShutdown();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean gameOver() {
		this.stop();
		return false; //
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getView() {
		
	}

	/**
	 * Game Loop
	 */
	private void gameLoop() {
		this.updateGame();
		this.render();
	}

	/**
	 * Update {@link GenericEntity}s position
	 */
	private void updateGame() {
		//this.model.update();	//Update entities's position
	}

	/**
	 * Update the game view
	 */
	private void render() {
		//
	}

	//
	private ScheduledExecutorService createTimer(int delay) {
		final ScheduledExecutorService timer = Executors.newScheduledThreadPool(
                Runtime.getRuntime().availableProcessors() + 1);
        timer.scheduleAtFixedRate(() -> this.gameLoop(), delay, 1000/FPS, TimeUnit.MILLISECONDS);
        return timer;
    }

	@Override
	public int getWindowWidth() {
		return 0;
	}

	@Override
	public int getWindowHeight() {
		return 0;
	} 
}
