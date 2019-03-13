package np.com.surojd.upload.dao;

import np.com.surojd.upload.database.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBFileDao extends JpaRepository<DBFile, String> {

}
