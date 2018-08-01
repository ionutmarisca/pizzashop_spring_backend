package core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import core.model.BaseEntity;

import java.io.Serializable;

/**
 * Created by Ionut on 19/6/2017.
 */
@NoRepositoryBean
@Transactional
public interface BaseRepository<T extends BaseEntity<ID>, ID extends Serializable> extends JpaRepository<T, ID> {
}

