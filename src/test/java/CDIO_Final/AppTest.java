package CDIO_Final;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import Datalayer.DTO.UserDTO;
import REST.Resources.UserResource;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void userCreateAndGetTest() {

        final ArrayList<String> roles = new ArrayList<>();
        roles.add("Administrator");

        UserDTO testUser = new UserDTO(1, "User", "Test", "2006882929", "UT", roles, 1);
        UserDTO responseUser;
        UserResource userFuncTest = new UserResource();

        System.out.println("Test: " + testUser.toString());

        try {
            userFuncTest.createUser(testUser);

            // handle response
            /*responseUser = userFuncTest.getUser(testUser.getUserID());
            System.out.println("Response: " + responseUser.toString());

            assertEquals(testUser, responseUser);*/

        } catch (final Exception e) {
            System.out.println("Connection failed");
        }

    }

}
