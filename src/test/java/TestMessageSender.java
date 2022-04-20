import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;


public class TestMessageSender {

    @Test
    public void testRussiaIp() {

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.152.22.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        HashMap testMap = new HashMap();
        testMap.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.152.22.11");

        String actual = messageSender.send(testMap);
        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected,
                actual);
    }

    @Test
    public void testUSAIp() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.152.22.11"))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        HashMap testMap = new HashMap();
        testMap.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.152.22.11");

        String actual = messageSender.send(testMap);
        String expected = "Welcome";

        Assertions.assertEquals(expected,
                actual);

    }




}




