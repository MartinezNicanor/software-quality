package jabberpoint.controllers;

import jabberpoint.Presentation;
import jabberpoint.slide.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeyControllerTest
{
    Presentation presentation;
    KeyController keyController;

    @BeforeEach
    void setup()
    {
        presentation = new Presentation();
        keyController = new KeyController(presentation);
    }

    @Test
    void PressedPageDownKey_ExecutesNextSlide_assertEqualsTrue()
    {
        presentation.append(new Slide());

        KeyEvent key = new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_DOWN);
        keyController.keyPressed(key);

        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void PressedEnterKey_ExecutesNextSlide_assertEqualsTrue()
    {
        presentation.append(new Slide());

        KeyEvent key = new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER);
        keyController.keyPressed(key);

        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void PressedPageUpKey_ExecutesPreviousSlide_asserEqualsTrue()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(2);

        KeyEvent key = new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_PAGE_UP);
        keyController.keyPressed(key);

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void PressedUpKey_ExecutesPreviousSlideTwice_assertEqualsTrue()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(3);

        KeyEvent key = new KeyEvent(new java.awt.Label(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP);
        keyController.keyPressed(key);
        keyController.keyPressed(key);

        assertEquals(1, presentation.getSlideNumber());
    }
}