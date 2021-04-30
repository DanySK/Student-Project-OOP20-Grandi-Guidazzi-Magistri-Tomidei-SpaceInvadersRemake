package controller;

import java.util.Optional;

import menu.Board;

/**
 * Implementation of {@link GameController}
 */
public class GameControllerImpl implements GameController{

	private final int FPS = 60;
	private final double FRAME_PERIOD = 1000000000 / FPS;
	private boolean isPaused;
	private Optional<Thread> timer;
	private Board view;

	/**
	 * Implementation of {@link GameController}
	 */
	public GameControllerImpl() {
		this.view = new Board(this);
		this.isPaused = false;
		this.timer = Optional.empty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startNewGame() {
		if(!this.isRunning()) {
			this.timer = Optional.of(new Timer());
			this.timer.get().run();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stop() {
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
	public void pause() {
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resume() {
		
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
		this.stop();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void victory() {
		this.stop();
	}

	/**
	 * Update {@link Entity}s position
	 */
	private void updateGame() {
		this.model.update();	//Update entities's position
	}

	/**
	 * Update {@link Entity}s graphics
	 */
	private void render() {
		this.view.getState().getMainPanel().repaint();
	}

	/**
	 * Thread for the game loop
	 */
	private class Timer extends Thread{
	
		private final int SLEEP_TIME = 5;	//waiting time between 2 loop cycles: 5 ms

		public void run() {
			long lastTime = System.nanoTime();		
			double delta = 0;
			int updates = 0;
			int frames = 0;
			long timer = System.currentTimeMillis();
			while(isRunning() && !isPaused) {
				long current = System.nanoTime();
				delta += (current - lastTime) / FRAME_PERIOD;
				lastTime = current;
				if(delta >= 1) {
					updates++;
					updateGame();
					render();
					frames++;
					delta--;
				}
				if(System.currentTimeMillis() - timer > 1000) {
					timer += 1000;
					System.out.println(updates + ": Ticks, Fps: " +frames +", Delta: " + delta);
					updates = 0;
					frames = 0;
				}
				try {
					Thread.sleep(this.SLEEP_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
