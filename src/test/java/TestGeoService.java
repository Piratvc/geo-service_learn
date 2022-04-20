import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class TestGeoService {
    @Test
    public void testIpCountry() {
        GeoService geoService = new GeoServiceImpl();

        Location actual = geoService.byIp("96.222.12.1");
        Location expected = new Location(("New York"), Country.USA, null, 0);

        Assertions.assertEquals(expected.getCountry(), actual.getCountry());

    }
}
