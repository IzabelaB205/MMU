package dao;

import dm.DataModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaoFileImplTest {
    DaoFileImpl<String> daoFile;
    String[] content;
    Long[] ids;
    int capacity;

    @BeforeEach
    public void init() {
        String filePath = "src/resources/datasource.txt";
        daoFile = new DaoFileImpl<>(filePath);
        content = new String[]{"GET", "REMOVE", "PUT"};
        ids = new Long[]{1L, 2L, 3L};
        capacity = 3;
    }

    @Test
    public void saveAndFindDataModelTest() {
        for(int i = 0; i < capacity; i++) {
            DataModel<String> dataModel = new DataModel<>(ids[i], content[i]);
            daoFile.save(dataModel);
        }

        assertEquals("GET", daoFile.find(ids[0]).getContent());
        assertEquals("REMOVE", daoFile.find(ids[1]).getContent());
        assertEquals("PUT", daoFile.find(ids[2]).getContent());
    }

    @Test
    public void removeDataModelTest() {
        for(int i = 0; i < capacity; i++) {
            DataModel<String> dataModel = new DataModel<>(ids[i], content[i]);
            daoFile.remove(dataModel);
        }

        assertNull(daoFile.find(ids[0]));
        assertNull(daoFile.find(ids[1]));
        assertNull(daoFile.find(ids[2]));
    }
}