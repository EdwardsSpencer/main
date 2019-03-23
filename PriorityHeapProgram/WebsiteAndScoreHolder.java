/**
 * 
 * @author Spencer
 *
 */
public class WebsiteAndScoreHolder
{
    private String website;
    private Integer overAllScore = null;
    private int score1 = 0;
    private int score2 = 0;
    private int score3 = 0;
    private int score4 = 0;
    /**
     * 
     * @param website the URL string
     * @param overallScore Score for the URL, how high the URL scored
     */
    public WebsiteAndScoreHolder(String website, int overallScore)
    {
        this.website = website;
        this.overAllScore = overallScore;
    }
    /**
     * 
     * @param website the URL in string form
     * @param score1 first score
     * @param score2 second score
     * @param score3 third score
     * @param score4 fourth score
     */
    public WebsiteAndScoreHolder(String website, int score1, int score2, int score3, int score4)
    {
        this.website = website;
        this.overAllScore = score1 + score2 + score3 + score4;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
    }
    /**
     * 
     * @return overall score of web URL
     */
    public int getScore()
    {
        return overAllScore;
    }
    /**
     * 
     * @param newScore to replace current overall score
     */
    public void setScore(int newScore)
    {
        overAllScore = newScore;
    }
    /**
     * 
     * @return website URL
     */
    public String getWebsite()
    {
        return website;
    }
    /**
     * 
     * @return string of all four scores
     */
    public String seeScoreItemized()
    {
        if( score1 == 0 &&  score2 == 0 &&  score3 == 0 &&  score4 == 0)
        {
            return (" " + overAllScore + " ");
        }
        else
            return (score1 + " " + score2 + " " + score3 + " " + score4);
    }
    public int getScore1() {
        // TODO Auto-generated method stub
        return score1;
    }
    public int getScore2() {
        // TODO Auto-generated method stub
        return score2;
    }
    public int getScore3() {
        // TODO Auto-generated method stub
        return score3;
    }
    public int getScore4() {
        // TODO Auto-generated method stub
        return score4;
    }
}
