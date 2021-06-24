package view.game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import controller.GameStatus;
import controller.ViewGameController;
import controller.gameStatusManager.ViewGameStatusManager;
import menu.Board;
import menu.StateGame;
import menu.StateMenu;
import menu.gameview.StateInGameMenu;
import model.entitiesutil.MappedEntity;

public class GameViewImpl extends KeyAdapter {
    private final ViewGameStatusManager flag;
    private final List<GameEvent> guiUpdateSet;
    private final Map<GameEvent,Boolean> keyPressed;
    private final Board board;

    public GameViewImpl(final ViewGameController controller) {
        this.flag = controller.getViewStatusManager();
        this.guiUpdateSet = Collections.synchronizedList(new ArrayList<>());
        this.keyPressed = Collections.synchronizedMap(new HashMap<>());
        this.board = new Board();
    }

    public List<GameEvent> getEvents(){
    	return this.keyPressed.entrySet().stream()
    			.filter(e -> e.getValue() == true)
    			.map(e-> e.getKey())
    			.collect(Collectors.toList());
    }

    public void updateGui(Set<MappedEntity> updates){
        this.guiUpdateSet.addAll(null);
        this.refresh();
    }
    
    private void refresh() {
       this.board.render();
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void keyPressed(KeyEvent e) {
    	this.setKeyValue(e.getKeyCode(), true);
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void keyReleased(KeyEvent e) {
    	this.setKeyValue(e.getKeyCode(), false);
    }
    
    private void setPause(){
    	this.board.setCurrentState(new StateInGameMenu(this.board));
        this.flag.pause();
    }

    private void resume(){
    	this.board.setCurrentState(new StateGame(this.board));
        this.flag.resume();
    }

    private void stop() {
    	this.board.setCurrentState(new StateMenu(this.board));
    	this.flag.stop();
    }

    private void restart() {
    	this.flag.restart();
    	this.board.setCurrentState(new StateGame(this.board));
    }
    
    private void setKeyValue(int code, boolean value) {
    	switch (code) {
    	case KeyEvent.VK_ESCAPE:
    		if(this.flag.getGameStatus().equals(GameStatus.PAUSED) && value) {
    			this.resume();
    		}
 
    		if(this.flag.getGameStatus().equals(GameStatus.RUNNING) && value) {
    			 this.setPause(); 
    		}
    		break;
    	case KeyEvent.VK_R:
    		if(this.flag.getGameStatus().equals(GameStatus.PAUSED) && value) {
    			this.restart();
    		}
    		break;
    	case KeyEvent.VK_S:
    		if(this.flag.getGameStatus().equals(GameStatus.PAUSED) && value) {
    			this.stop();
    		}
    		break;
    	case KeyEvent.VK_LEFT:
    	case KeyEvent.VK_RIGHT:
    	case KeyEvent.VK_SPACE:
    		this.keyPressed.put(this.toGameEvent(code), value);
    	}
    }
        
    private GameEvent toGameEvent(int code) {
    	switch (code) {
		case KeyEvent.VK_LEFT:
			return GameEvent.LEFT;

		case KeyEvent.VK_RIGHT:
			return GameEvent.RIGHT;

		case KeyEvent.VK_SPACE:
			return GameEvent.FIRE;

		default:
			throw new IllegalArgumentException("wrong typing");
		}
    }
    
}