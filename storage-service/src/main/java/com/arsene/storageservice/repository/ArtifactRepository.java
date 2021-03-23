package com.arsene.storageservice.repository;

import com.arsene.storageservice.entity.artifacts.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, String> {

}
