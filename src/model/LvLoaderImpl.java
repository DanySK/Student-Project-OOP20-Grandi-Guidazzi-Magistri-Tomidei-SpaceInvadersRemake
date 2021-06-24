package model;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import com.google.gson.Gson;

/**
 * {@link LvLoader} implementation
 *
 */
public class LvLoaderImpl implements LvLoader{
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Level> loadLevel(int levelNumber) {
		Optional<Level> JSonEntities = Optional.empty();
		try {
	        // create Gson instance
	        Gson gson = new Gson();

	        // create a reader
	        Reader reader = Files.newBufferedReader(Paths.get("src/res/levels/LV" + levelNumber + ".json"));

	        // convert JSON string to Level object
	        JSonEntities = Optional.ofNullable(gson.fromJson(reader, Level.class));

	        // close reader
	        reader.close();

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

		return JSonEntities;
	}
}
