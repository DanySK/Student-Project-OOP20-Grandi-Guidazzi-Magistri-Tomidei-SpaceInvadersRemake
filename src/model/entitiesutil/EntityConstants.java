package model.entitiesutil;

public class EntityConstants { 
	
	public class PlayerBullet{
		public final static int PLAYER_BULLET_MU_X = 1;
		public final static int  PLAYER_BULLET_INITIAL_WIDTH = 0;
		public final static int  PLAYER_BULLET_INITIAL_HEIGHT = 0;
		public final static double  PLAYER_BULLET_MU_Y = 0;
	}
		
	public class Player{
		public final static int PLAYER_INITIAL_WIDTH = 0;
		public final static int PLAYER_INITIAL_HEIGHT = 0;
		public final static double PLAYER_INITIAL_MU_X = 0;
		public final static double PLAYER_INITIAL_MU_Y = 0;
		public final static int PLAYER_MAX_HITS = 3;
	}

	public class Boss1 {
		public final static int INITIAL_WIDTH = 0;
		public final static int INITIAL_HEIGHT = 0;
		public final static double INITIAL_MU_X = 0;
		public final static double INITIAL_MU_Y = 0;
		public final static int MAX_HITS = 0;
	}

	public class Boss2 {
		public final static int INITIAL_WIDTH = 0;
		public final static int INITIAL_HEIGHT = 0;
		public final static double INITIAL_MU_X = 0;
		public final static double INITIAL_MU_Y = 0;
		public final static int HITS_2ND_PHASE = 0;
		public final static int MAX_HITS = 0;
	}

	public class Boss3 {
		public final static int INITIAL_WIDTH = 0;
		public final static int INITIAL_HEIGHT = 0;
		public final static double INITIAL_MU_X = 0;
		public final static double INITIAL_MU_Y = 0;
		public final static int MAX_HITS = 0;
		public final static int MAX_SPEED = 0;
		public final static int HITS_2ND_PHASE = MAX_HITS/2;
	}

	public class MonoDirectionEnemyBullet {
		public final static int INITIAL_WIDTH = 0;
		public final static int INITIAL_HEIGHT = 0;
		public final static double MAX_MU_Y = 0;
	}

	public class MultiDirectionEnemyBullet{
		public final static int INITIAL_WIDTH = 0;
		public final static int INITIAL_HEIGHT = 0;
		public final static double INITIAL_MU_X = 0;
		public final static double MAX_MU_Y = 0;
		public final static int POSSIBLE_DIRECTIONS = 3;
	}
}
