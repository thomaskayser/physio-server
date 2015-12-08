import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tom on 28.11.2015.
 */
public class SchemaGenerator {
    public static void main(String[] args) {

        Map properties = new HashMap();
        properties.put("javax.persistence.database-product-name", "Oracle");
        properties.put("javax.persistence.database-major-version", 12);
        properties.put("javax.persistence.database-minor-version", 1);
        properties.put("javax.persistence.schema-generation.scripts.action", "drop-and-create");
        properties.put("javax.persistence.schema-generation.scripts.drop-target", "jpa21-generate-schema-no-connection-drop.jdbc");
        properties.put("javax.persistence.schema-generation.scripts.create-target", "jpa21-generate-schema-no-connection-create.jdbc");

        Persistence.generateSchema("default", properties);

    }
}

