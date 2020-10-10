package io.floofdoggo.youtubeplaylistscanner.DAO;

import io.floofdoggo.youtubeplaylistscanner.DAO.entity.VideoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends CrudRepository<VideoEntity, Integer> {
    VideoEntity getById(String video_id);
}
