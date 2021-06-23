package controller;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import controller.gameStatusManager.ControllerGameStatusManager;
import controller.gameStatusManager.GameStatusManagerImpl;
import controller.gameStatusManager.ViewGameStatusManager;
import model.Model;
import model.ModelImpl;
import model.entitiesutil.MappedEntity;
import view.game.GameViewImpl;

/**
 * Implementation of {@link GameController}
 */
public class GameControllerImpl implements GameController, GameViewController {

	private final int FPS = 60;
	private final int DEL = 1000/FPS;
	private final ControllerGameStatusManager stateGameMenager;
	private final Model model;
	private final GameViewImpl view;

	private ScheduledExecutorService loop;
	private int frames;

	/**
	 * Implementation of {@link GameController}
	 */
	public GameControllerImpl() {
		this.stateGameMenager = new GameStatusManagerImpl();
		this.model = new ModelImpl(this);
		this.view = new GameViewImpl((ViewGameStatusManager) this.stateGameMenager);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startNewGame() {
		if(!this.isRunning()) {
			//
			this.frames = 0;
			this.stateGameMenager.setStart();
			this.loop = Executors.newScheduledThreadPool
					(Runtime.getRuntime().availableProcessors()-1);
			this.loop.scheduleWithFixedDelay(()-> gameLoop(), DEL, DEL, TimeUnit.MILLISECONDS);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stop() {
		if(this.isRunning()) {
			this.loop.shutdownNow();
			this.stateGameMenager.stop();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isRunning() {
		return this.stateGameMenager.getGameStatus().equals(GameStatus.RUNNING)
				&& !this.loop.isShutdown() && !this.loop.isTerminated();
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
	public GameViewImpl getView() {
		return this.view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MappedEntity> getLevelEntities() {
		return this.model.getMappedEntities();
	}

	/**
	 * Game Loop
	 */
	private void gameLoop() {
		this.stateGameMenager.isGamePaused();
		switch(this.stateGameMenager.getGameStatus()) {
			case STOPPED:
				this.stateGameMenager.setResume();
				this.stop();
				break;
			case RESTARTED:
				this.frames = 0;
				//this.model.restartLvl();
				this.stateGameMenager.setResume();
				break;
			case RESUMED:
				this.stateGameMenager.setResume();
				break;
			default:
				break;
		}
		this.updateGame();
		this.render();
	}

	/**
	 * Update {@link GenericEntity}s position
	 */
	private void updateGame() {
		this.model.updateEntityLevel(frames++);	//Update entities's position
	}

	/**
	 * Update the game view
	 */
	private void render() {
		//
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getWindowWidth() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getWindowHeight() {
		return 0;
	}
}
