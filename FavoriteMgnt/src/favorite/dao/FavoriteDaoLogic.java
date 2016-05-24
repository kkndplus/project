package favorite.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import favorite.entity.Favorite;

public class FavoriteDaoLogic implements FavoriteDao {
	//
	private static Map<String, Favorite> favoriteRepo = new HashMap<String, Favorite>();
	private static int favoriteId;
	
	public FavoriteDaoLogic() {
		//empty
	}
	
	private String nextFavoriteId() {
		//
		favoriteId++;
		return String.format("%04d", favoriteId);
	}
	
	@Override
	public void create(Favorite favorite) {
		//
		favorite.setId(nextFavoriteId());
		favoriteRepo.put(favorite.getId(), favorite);
	}

	@Override
	public List<Favorite> retrieveAll() {
		//
		List<Favorite> allFavorites = new ArrayList<>(favoriteRepo.values());
		return allFavorites;
	}

	@Override
	public void update(Favorite favorite) {
		//
		favoriteRepo.put(favorite.getId(), favorite);
	}

	@Override
	public void delete(String id) {
		//
		favoriteRepo.remove(id);
	}

	@Override
	public Favorite retrieve(String id) {
		//
		return favoriteRepo.get(id);
	}

}
