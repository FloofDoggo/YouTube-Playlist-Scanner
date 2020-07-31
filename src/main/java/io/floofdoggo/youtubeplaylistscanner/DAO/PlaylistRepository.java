package io.floofdoggo.youtubeplaylistscanner.DAO;

import io.floofdoggo.youtubeplaylistscanner.DAO.entity.PlaylistEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends CrudRepository<PlaylistEntity, Integer> {
}
