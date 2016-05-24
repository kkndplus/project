package favorite.dao;

import java.util.List;

import favorite.entity.Favorite;

public interface FavoriteDao {
	//
	void create(Favorite favorite);
	List<Favorite> retrieveAll();
	void update(Favorite favorite);
	void delete(String id);
	Favorite retrieve(String id);
}
