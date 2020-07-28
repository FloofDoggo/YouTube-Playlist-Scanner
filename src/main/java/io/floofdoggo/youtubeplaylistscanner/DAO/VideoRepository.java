package io.floofdoggo.youtubeplaylistscanner.DAO;

import io.floofdoggo.youtubeplaylistscanner.DAO.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Integer> {
}
