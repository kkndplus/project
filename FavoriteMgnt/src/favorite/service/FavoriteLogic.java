package favorite.service;

import java.util.List;

import favorite.dao.FavoriteDao;
import favorite.dao.FavoriteDaoLogic;
import favorite.entity.Favorite;

public class FavoriteLogic implements FavoriteService {
	//
	private FavoriteDao favoriteDao;
	
	public FavoriteLogic() {
		//
		favoriteDao = new FavoriteDaoLogic();
	}
	
	@Override
	public List<Favorite> findAllFavorites() {
		//
		return favoriteDao.retrieveAll();
	}

	@Override
	public void registerFavorite(Favorite favorite) {
		//
		favoriteDao.create(favorite);
	}

	@Override
	public void modifyFavorite(Favorite favorite) {
		//
		favoriteDao.update(favorite);
	}

	@Override
	public void removeFavorite(String id) {
		//
		favoriteDao.delete(id);
	}

	@Override
	public Favorite findFavorite(String id) {
		//
		return favoriteDao.retrieve(id);
	}

}
