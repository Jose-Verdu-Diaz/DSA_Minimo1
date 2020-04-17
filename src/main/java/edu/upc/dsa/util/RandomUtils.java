package edu.upc.dsa.util;

import net.moznion.random.string.RandomStringGenerator;

import java.util.Set;

public class RandomUtils {
    public static String getId(Set existingId) {
        //Se debe pasar un set de id (keySet() si se trata de hash map)
        RandomStringGenerator generator = new RandomStringGenerator();
        String randomString = generator.generateFromPattern("ssssssss");
        //8 random "salt" characters

        while(existingId.contains(randomString)){
            //avoid repeated id
            randomString = generator.generateFromPattern("ssssssss");
        }
        return randomString;
    }
}
