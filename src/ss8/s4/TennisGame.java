package ss8.s4;

public class TennisGame {


        public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
            if (m_score1 == m_score2) {
                return getEvenScore(m_score1);
            } else if (m_score1 >= 4 || m_score2 >= 4) {
                return getAdvancedScore(m_score1, m_score2);
            } else {
                return getNormalScore(m_score1, m_score2);
            }
        }

        private static String getEvenScore(int score) {
            switch (score) {
                case 0:
                    return "Love-All";
                case 1:
                    return "Fifteen-All";
                case 2:
                    return "Thirty-All";
                case 3:
                    return "Forty-All";
                default:
                    return "Deuce";
            }
        }

        private static String getAdvancedScore(int m_score1, int m_score2) {
            int scoreDifference = m_score1 - m_score2;
            if (scoreDifference == 1) {
                return "Advantage player1";
            } else if (scoreDifference == -1) {
                return "Advantage player2";
            } else if (scoreDifference >= 2) {
                return "Win for player1";
            } else {
                return "Win for player2";
            }
        }

        private static String getNormalScore(int m_score1, int m_score2) {
            return getScoreName(m_score1) + "-" + getScoreName(m_score2);
        }

        private static String getScoreName(int score) {
            switch (score) {
                case 0:
                    return "Love";
                case 1:
                    return "Fifteen";
                case 2:
                    return "Thirty";
                case 3:
                    return "Forty";
                default:
                    throw new IllegalArgumentException("Invalid score: " + score);
            }
        }

}
