

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  Kelachi Charles-Beke(201651312) and Divine Badibanga(201765203)
 * @version 11.06.2019
 */
public class CommentTest
{
    private Comment comment1;
    private Comment comment2;

    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        comment1 = new Comment("Mabel", "Onwards Aoshima!", 5);
        comment2 = new Comment("Schmebulock", "Schmebulock", 3);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test for correct instantiation of constructors
       */
    @Test
    public void testInit()
    {
        assertEquals("Schmebulock", comment2.getAuthor());
        assertEquals(3, comment2.getRating());
        assertEquals(0, comment2.getVoteCount());
        assertEquals("Mabel", comment1.getAuthor());
        assertEquals(5, comment1.getRating());
        assertEquals(0, comment1.getVoteCount());
    }

    /**
     * Test getRating() method for correct returned value
       */
    @Test
    public void testGetRating()
    {
        assertEquals(5, comment1.getRating());
        assertEquals(3, comment2.getRating());
    }

    /**
     * Test downvote() method for correct updating of rating value
       */
    @Test
    public void testDownvote()
    {
        comment2.downvote();
        comment2.downvote();
        assertEquals(-2, comment2.getVoteCount());
        comment1.downvote();
        assertEquals(-1, comment1.getVoteCount());
    }

}





