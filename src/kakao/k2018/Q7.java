package kakao.k2018;

/**
 * 7. 블록 게임 정답률: 5.85% 문제 풀러 가기 프렌즈 블록이라는 신규 게임이 출시되었고, 어마어마한 상금이 걸린 이벤트 대회가 개최 되었다. 이 대회는 사람을 대신해서
 * 플레이할 프로그램으로 참가해도 된다는 규정이 있어서, 게임 실력이 형편없는 프로도는 프로그램을 만들어서 참가하기로 결심하고 개발을 시작하였다. 프로도가 우승할 수 있도록
 * 도와서 빠르고 정확한 프로그램을 작성해 보자. 게임규칙 아래 그림과 같이 1×1 크기의 블록을 이어 붙여 만든 3 종류의 블록을 회전해서 총 12가지 모양의 블록을 만들 수
 * 있다.
 * <p>
 * 1 x 1 크기의 정사각형으로 이루어진 N x N 크기의 보드 위에 이 블록들이 배치된 채로 게임이 시작된다. (보드 위에 놓인 블록은 회전할 수 없다). 모든 블록은 블록을
 * 구성하는 사각형들이 정확히 보드 위의 사각형에 맞도록 놓여있으며, 선 위에 걸치거나 보드를 벗어나게 놓여있는 경우는 없다. 플레이어는 위쪽에서 1 x 1 크기의 검은 블록을
 * 떨어뜨려 쌓을 수 있다. 검은 블록은 항상 맵의 한 칸에 꽉 차게 떨어뜨려야 하며, 줄에 걸치면 안된다. 이때, 검은 블록과 기존에 놓인 블록을 합해 속이 꽉 채워진
 * 직사각형을 만들 수 있다면 그 블록을 없앨 수 있다. 예를 들어 검은 블록을 떨어뜨려 아래와 같이 만들 경우 주황색 블록을 없앨 수 있다.
 * <p>
 * 빨간 블록을 가로막던 주황색 블록이 없어졌으므로 다음과 같이 빨간 블록도 없앨 수 있다.
 * <p>
 * 그러나 다른 블록들은 검은 블록을 떨어뜨려 직사각형으로 만들 수 없기 때문에 없앨 수 없다. 따라서 위 예시에서 없앨 수 있는 블록은 최대 2개이다. 보드 위에 놓인 블록의
 * 상태가 담긴 2차원 배열 board가 주어질 때, 검은 블록을 떨어뜨려 없앨 수 있는 블록 개수의 최댓값을 구하라. 제한사항 board는 블록의 상태가 들어있는 N x N
 * 크기 2차원 배열이다. N은 4 이상 50 이하다. board의 각 행의 원소는 0 이상 200 이하의 자연수이다. 0 은 빈 칸을 나타낸다. board에 놓여있는 각 블록은
 * 숫자를 이용해 표현한다. 잘못된 블록 모양이 주어지는 경우는 없다. 모양에 관계 없이 서로 다른 블록은 서로 다른 숫자로 표현됩니다. 예를 들어 문제에 주어진 예시의 경우
 * 다음과 같이 주어진다.
 * <p>
 * 입출력 예 board	result [[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,4,0,0,0],[0,0,0,0,0,4,4,0,0,0],[0,0,0,0,3,0,4,0,0,0],[0,0,0,2,3,0,0,0,5,5],[1,2,2,2,3,3,0,0,0,5],[1,1,1,0,0,0,0,0,0,5]]	2
 * 입출력 예 설명 입출력 예 #1 문제에 주어진 예시와 같음 문제 풀이 문제를 이해하는 것은 어렵지 않지만 제거해야 할 블록을 찾기 위한 아이디어가 필요합니다. 문제에서는 검은
 * 블록을 떨어뜨린다고 되어있으나, 실제로 검은 블록을 떨어뜨리지 않고 순서대로 검은 블록으로 채워 나가기만 해도 삭제될 블록을 찾을 수 있습니다. 먼저 게임 보드의 왼쪽
 * 위(혹은 오른쪽 위)부터 가로 방향으로 한 줄씩 순서대로 진행하면서 빈칸에 검은 블록을 채울 수 있는지 확인합니다. 현재 칸이 빈칸이라면 위쪽으로 삭제되지 않은 블록이 있는지
 * 확인합니다. 만약 다른 블록이 없다면 검은 블록으로 채우고, 그렇지 않으면 그대로 빈칸으로 둡니다. 칸 하나를 확인한 후에는 해당 칸을 포함하는 칸 중에서 삭제할 수 있는
 * 블록이 있는지 확인합니다. 블록이 사라질 수 있는지 판단은 검은 블록 두 개와 같은 색 블록 4개가 2×3, 3×2의 직사각형 안에 들어있는지 확인하면 됩니다. 블록을 지운
 * 경우에 지워진 칸을 그대로 둘지, 혹은 검은 블록으로 채울지 확인하는 과정이 필요합니다. 블록이 삭제된 칸이어도 검은 블록으로 채울 수 없는 경우가 있기 때문입니다. 지워진
 * 칸을 기준으로 위쪽에 삭제되지 않은 블록이 있는지 확인하여 검은 블록을 적절히 채웁니다(삭제되는 블록을 찾는 방향에 따라 조금 다를 수도 있습니다). 블록이 삭제되면 카운트를
 * 1 증가시키고, 게임 보드의 모든 칸에 대해 삭제될 블록을 찾은 후 카운트된 값을 반환하면 됩니다. 또 다른 방법으로, 문제의 설명대로 위에서 블록을 떨어뜨려서 없앨 수 있는
 * 블록을 차례대로 찾아서 제거하는 것을 생각해 볼 수 있습니다. 도형의 모양을 자세히 보면, 제거할 수 있는 도형은 채워야 할 공간이 위쪽으로 열려있는 5가지뿐임을 알 수
 * 있습니다. 최상단 좌측부터 검사를 시작해 도형이 있는 칸(0보다 큰 값)을 만나면, 주변 값들을 확인해서 제거 가능한 도형 중 하나인지를 체크합니다. 만약, 제거 가능한 도형
 * 중 하나라면 도형에서 채워야 하는 공간부터 최상단까지 모든 값이 비어있는지를 체크합니다. 모두 비어있다면 이는 없앨 수 있다는 뜻이므로 이 도형을 0으로 채워 제거합니다.
 * 제거 가능한 도형을 모두 찾을 때까지 이 과정을 반복하고, 도형을 제거할 때마다 카운트를 증가시켜주면 됩니다.
 */
public class Q7 {

    int N;
    int[][] Board;

    public boolean canFill(int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (Board[i][col] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canFind(int row, int col, int h, int w) {
        int emptyCnt = 0;
        int lastValue = -1;
        for (int r = row; r < row + h; ++r) {
            for (int c = col; c < col + w; ++c) {
                if (Board[r][c] == 0) {
                    // 지금 위치에 공간을 채울 수 있는지 체크하는 함수
                    if (canFill(r, c)) {
                        return false;
                    }
                    if (++emptyCnt > 2) {
                        return false;
                    }
                } else {
                    // 서로 다른 영역일 때 성립하지 않음
                    if (lastValue != -1 && lastValue != Board[r][c]) {
                        return false;
                    }

                    lastValue = Board[r][c];
                }
            }
        }

        for (int r = row; r < row + h; ++r) {
            for (int c = col; c < col + w; ++c) {
                Board[r][c] = 0;
            }
        }

        return true;
    }

    public int solution(int[][] board) {
        Board = board;
        N = board.length;
        int answer = 0;
        int cnt;
        do {
            cnt = 0;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (i < N - 2 && j < N - 3 && canFind(i, j, 2, 3)) {
                        ++cnt;
                    } else if (i < N - 3 && j < N - 2 && canFind(i, j, 3, 2)) {
                        ++cnt;
                    }
                }
            }
            answer += cnt;
        }
        while (cnt != 0);
        return answer;
    }
}
