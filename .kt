fun needlemanWunsch(seq1: String, seq2: String, gapPenalty: Int, matchScore: Int, mismatchPenalty: Int): Int {
    val m = seq1.length
    val n = seq2.length
    val score = Array(m + 1) { IntArray(n + 1) }
    for (i in 0..m) {
        score[i][0] = i * gapPenalty
    }
    for (j in 0..n) {
        score[0][j] = j * gapPenalty
    }
    for (i in 1..m) {
        for (j in 1..n) {
            val match = if (seq1[i - 1] == seq2[j - 1]) matchScore else mismatchPenalty
            score[i][j] = maxOf(
                score[i - 1][j - 1] + match,
                score[i - 1][j] + gapPenalty,
                score[i][j - 1] + gapPenalty
            )
        }
    }
    return score[m][n]
}
