package ru.job4j.stream;

import junit.framework.TestCase;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest extends TestCase {
    @Test
    public void testCollect() {
        Address address1 = new Address("City1", "St1", 1, 2);
        Address address2 = new Address("City3", "St1", 1, 4);
        Address address3 = new Address("City1", "St1", 1, 2);
        Address address4 = new Address("Alta", "St1", 1, 2);
        List<Profile> profileList = List.of(
                new Profile(address1),
                new Profile(address2),
                new Profile(address3),
                new Profile(address4)
        );

        Profiles profiles = new Profiles();
        List<Address> addresses = profiles.collect(profileList);
        List<Address> expected = List.of(address4, address3, address2);
        assertThat(addresses, is(expected));
    }
}