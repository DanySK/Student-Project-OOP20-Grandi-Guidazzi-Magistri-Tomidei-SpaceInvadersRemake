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

import controller.gameStatusMenager.ViewMonitor;
import model.entitiesutil.typeentities.GenericEntity;
import view.GraphicsView;
import view.GraphicsViewImpl;

public class GameViewImpl extends KeyAdapter {
    private final ViewMonitor flag;
    private final Set<Integer> guiUpdateSet;
    private final ExecutorService executorService;
    private final Map<GameEvent,Boolean> keyPressed;
    private final GraphicsView graphicsView;
    private boolean isPause;


    public GameViewImpl(final ViewMonitor flag) {
        this.flag = flag;
        this.guiUpdateSet = Collections.synchronizedSet(new HashSet<>());
        this.executorService = Executors.newCachedThreadPool();
        this.keyPressed = Collections.synchronizedMap(new HashMap<>());
        this.isPause = false;
        this.graphicsView = new GraphicsViewImpl();
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
        //this.executorService.execute(this::refresh); //non e' detto che sia da fare nell' executor service
    }
    

    private void refresh(Set<GenericEntity> entity) {
       this.graphicsView.updateEntityImages(entity);
    }


    private void setPause(){
    	this.isPause = true;
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
			throw new IllegalArgumentException("smetti di spingere tasti sbagliati coglione");
		}
    }
    
}
