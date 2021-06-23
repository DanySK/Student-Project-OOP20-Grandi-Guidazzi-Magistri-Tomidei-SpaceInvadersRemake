package view.game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import controller.gameStatusManager.ViewGameStatusManager;
import model.entitiesutil.typeentities.GenericEntity;
import view.GraphicsView;
import view.GraphicsView;

public class GameViewImpl extends KeyAdapter {
    private final ViewGameStatusManager flag;
    private final Set<Integer> guiUpdateSet;
    private final Map<GameEvent,Boolean> keyPressed;
    private boolean isPause;


    public GameViewImpl(final ViewGameStatusManager flag) {
        this.flag = flag;
        this.guiUpdateSet = Collections.synchronizedSet(new HashSet<>());
        this.keyPressed = Collections.synchronizedMap(new HashMap<>());
        this.isPause = false;
    }

    public Set<GameEvent> getEvents(){
    	return this.keyPressed.entrySet().stream()
    			.filter(e -> e.getValue() == true)
    			.map(e-> e.getKey())
    			.collect(Collectors.toSet());
    }


    private void onEvent(){
        this.guiUpdateSet.add(null);
    }

    public void updateGui(Set<Integer/*lista di updates in verita'*/> updates){
        this.guiUpdateSet.addAll(updates);
    }
    

    private void refresh(Set<GenericEntity> entity) {
      
    }


    private void setPause(){
    	this.isPause = true; //usare game status al posto del booleano this.flag.getStatus()
        this.flag.pause();
    }

    private void resume(){
    	this.isPause = false;
        this.flag.resume();
    }

    private void onStop(){
        this.flag.stop();
    }
    @Override
    public void keyPressed(KeyEvent e) {
    	this.setKeyValue(e.getKeyCode(), true);
    }
    @Override
    public void keyReleased(KeyEvent e) {
    	this.setKeyValue(e.getKeyCode(), false);
    }
    
    private void setKeyValue(int code, boolean value) {
    	switch (code) {
    	case KeyEvent.VK_ESCAPE:
    			if(this.isPause) {
    				this.resume();
    			}else {
    				 this.setPause(); 
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
