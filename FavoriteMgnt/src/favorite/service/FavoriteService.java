package favorite.service;

import java.util.List;

import favorite.entity.Favorite;

public interface FavoriteService {
	//
	List<Favorite> findAllFavorites();
	void registerFavorite(Favorite favorite);
	void modifyFavorite(Favorite favorite);
	void removeFavorite(String id);
	Favorite findFavorite(String id);
}
