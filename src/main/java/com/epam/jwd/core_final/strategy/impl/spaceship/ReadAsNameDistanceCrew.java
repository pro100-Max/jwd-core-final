package com.epam.jwd.core_final.strategy.impl.spaceship;

import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.service.impl.MyHelpfulServiceImpl;
import com.epam.jwd.core_final.service.impl.SpaceshipServiceImpl;
import com.epam.jwd.core_final.strategy.ReadFromFileSpaceshipStrategy;

import java.util.Collection;
import java.util.Scanner;

public class ReadAsNameDistanceCrew implements ReadFromFileSpaceshipStrategy {
    @Override
    public void read(Scanner in, Collection<Spaceship> spaceships) {
        while (in.hasNextLine()) {
            String[] inputDataArray = in.nextLine().split(";");
            try {
                spaceships.add(SpaceshipServiceImpl.getInstance().createSpaceship(
                        inputDataArray[0],
                        Long.valueOf(inputDataArray[1]),
                        MyHelpfulServiceImpl.getInstance().makeCrew(inputDataArray[2])));
            } catch (InvalidStateException e) {
                e.printStackTrace();
            }
        }
    }
}
