package testsunitaires;

import menufact.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTest {

    private Client client;

    @BeforeEach
    public void setup(){
        client = new Client(1, "Georges", "1234");
    }

    @Test
    void getIdClient() {
        assertEquals(1, client.getIdClient());
    }

    @Test
    void setIdClient() {
        client.setIdClient(2);
        assertEquals(2, client.getIdClient());
    }

    @Test
    void getNom() {
        assertEquals("Georges", client.getNom());
    }

    @Test
    void setNom() {
        client.setNom("Pierre");
        assertEquals("Pierre", client.getNom());
    }

    @Test
    void getNumeroCarteCredit() {
        assertEquals("1234", client.getNumeroCarteCredit());
    }

    @Test
    void setNumeroCarteCredit() {
        client.setNumeroCarteCredit("12345");
        assertEquals("12345", client.getNumeroCarteCredit());
    }
}