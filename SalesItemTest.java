

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  Kelachi Charles-Beke(201651312) and Divine Badibanga(201765203)
 * @version 11.06.2019
 */
public class SalesItemTest
{
    private SalesItem salesIte1;
    private SalesItem salesIte2;
    private SalesItem salesIte3;

    

    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
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
        salesIte1 = new SalesItem("A Martian's Kidney", 80000);
        salesIte2 = new SalesItem("Ocean In A Bottle", 2000);
        salesIte3 = new SalesItem("Cloud", 500000);
        //Cloud
        salesIte2.addComment("Poseidon", "Mine came with a little crab in it. Adorable!", 5);
        salesIte2.upvoteComment(0);
        salesIte2.upvoteComment(0);
        salesIte2.upvoteComment(0);
        //Ocean in a bottle
        salesIte3.addComment("Marceline", "super cute", 4);
        salesIte3.addComment("Finn", "it rains and everything", 5);
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
     * Tests whether getNumberOfComments() works
       */
    @Test
    public void testGetNumberOfComments()
    {
        assertEquals(0, salesIte1.getNumberOfComments());
        assertEquals(1, salesIte2.getNumberOfComments());
        assertEquals(2, salesIte3.getNumberOfComments());
    }

    /**
     * Tests for proper instantiation of constructors
       */
    @Test
    public void testInit()
    {
        //Martian's Kidney
        assertEquals("A Martian's Kidney", salesIte1.getName());
        assertEquals(80000, salesIte1.getPrice());
        //Ocean In A Bottle
        assertEquals("Ocean In A Bottle", salesIte2.getName());
        assertEquals(2000, salesIte2.getPrice());
        ///Cloud
        assertEquals("Cloud", salesIte3.getName());
        assertEquals(500000, salesIte3.getPrice());
    }

    /**
     * Tests for proper addition of valid comment and check to see if count
     * of comments is updated
       */
    @Test
    public void testAddComment()
    {
        assertEquals(true, salesIte1.addComment("Mark Watney", "looks authentic", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
        assertNotNull(salesIte1.getComment(0));
    }

    /**
     * Tests whether a comment by the same author can be added to the same
     * item (it shouldnt)
       */
    @Test
    public void testSameAuthor()
    {
        assertEquals(false, salesIte2.addComment("Poseidon", "tastes super briney", 4));
        assertEquals(1, salesIte2.getNumberOfComments());
        assertNull(salesIte2.getComment(1));
    }

    /**
     * Tests whether a comment with an invalid rating can be successfully 
     * added (it shouldnt)
       */
    @Test
    public void testInvalidRating()
    {
        assertEquals(false, salesIte2.addComment("Neptune", "this is a huge ripoff", 0));
        assertEquals(false, salesIte2.addComment("Ariel", "Reminds me of home", 10));
        assertEquals(1, salesIte2.getNumberOfComments());
    }

    /**
     * Tests whether a comment is removed successfully and count updated
       */
    @Test
    public void testRemoveComment()
    {
        salesIte3.removeComment(1);
        assertEquals(1, salesIte3.getNumberOfComments());
    }

    /**
     * Tests if vote count is updated after upvote() is called
       */
    @Test
    public void testUpvote()
    {
        salesIte3.upvoteComment(0);
        salesIte3.upvoteComment(0);
        assertEquals(2, salesIte3.getComment(0).getVoteCount());
    }
    
    
    /**
     * Tests findMostHelpfulComment() method to find most helpful method
       */
    @Test
    public void testFindMostHelpfulComment()
    {
        salesIte3.upvoteComment(0);
        salesIte3.upvoteComment(1);
        salesIte3.upvoteComment(1);
        assertEquals(salesIte3.getComment(1), salesIte3.findMostHelpfulComment());
    }

    /**
     * Tests if vote count is updated when downvote() is called
       */
    @Test
    public void testDownvote()
    {
        salesIte2.downvoteComment(0);
        salesIte2.downvoteComment(0);
        assertEquals(1, salesIte2.getComment(0).getVoteCount());
    }
}















