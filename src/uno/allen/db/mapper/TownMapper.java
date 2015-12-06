package uno.allen.db.mapper;

import java.util.List;

import uno.allen.entity.Town;

public interface TownMapper {
	void insertTown(Town town);
	void deleteTown(String townName);
	List<Town> getTownByCountyID(int ID);
}
