package controller;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import controller.gameStatusMenager.ControllerMonitor;
import controller.gameStatusMenager.MonitorImpl;
import controller.gameStatusMenager.ViewMonitor;
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
	private final ScheduledExecutorService loop;
	private final ControllerMonitor stateGameMenager;
	private final Model model;
	@SuppressWarnings("unused")
	private final GameViewImpl view;

	/**
	 * Implementation of {@link GameController}
	 */
	public GameControllerImpl() {
		this.stateGameMenager = new MonitorImpl();
		this.model = new ModelImpl(this);
		this.view = new GameViewImpl((ViewMonitor) this.stateGameMenager);
		this.loop = Executors.newScheduledThreadPool
				(Runtime.getRuntime().availableProcessors()-1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void startNewGame() {
		if(!this.isRunning()) {
			//
			this.stateGameMenager.setStart();
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
	public void getView() {
		
	}

	@Override
	public Set<MappedEntity> getEntitiesLevel() {
		return this.model.getMappedEntities();
	}

	/**
	 * Game Loop
	 */
	private void gameLoop() {
		this.stateGameMenager.isGamePaused();
		switch(this.stateGameMenager.getGameStatus()) {
			case STOPPED:
				this.stop();
				break;
			case RESTARTED:
				//this.model.restartLvl();
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
		//this.model.update();	//Update entities's position
	}

	/**
	 * Update the game view
	 */
	private void render() {
		//
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
