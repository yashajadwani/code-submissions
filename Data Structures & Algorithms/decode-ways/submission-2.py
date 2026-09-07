class Solution:

    def numDecodings(self, s: str) -> int:

        n = len(s)

        if s[0] == "0":
            return 0

        if n == 1:
            return 1

        dp = [0] * n

        # Base case: last character
        if s[n - 1] != "0":
            dp[n - 1] = 1

        # Base case: second-last character
        if s[n - 2] != "0":
            dp[n - 2] = dp[n - 1]

            # Can the last two digits form a letter?
            if 10 <= int(s[n - 2:n]) <= 26:
                dp[n - 2] += 1

        # Fill the rest from right to left
        for i in range(n - 3, -1, -1):

            # Take one digit
            if s[i] != "0":
                dp[i] = dp[i + 1]

                # Take two digits
                if 10 <= int(s[i:i + 2]) <= 26:
                    dp[i] += dp[i + 2]

        return dp[0]