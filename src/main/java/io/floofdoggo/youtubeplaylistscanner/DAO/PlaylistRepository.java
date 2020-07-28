package io.floofdoggo.youtubeplaylistscanner.DAO;

import io.floofdoggo.youtubeplaylistscanner.DAO.entity.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Integer> {
}
