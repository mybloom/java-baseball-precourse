1.  컴퓨터(상대방)는 1~9까지의 서로 다른 수로 이루어진 3자리 수를 설정한다. 
   - 서로 각기 다른 1~9사이의 수를 3자리 뽑아 생성.
2.  사용자가 답을 맞추도록 입력을 요청한다.
   - “숫자를 입력해주세요 : 123“
3. 사용자가 입력한 값이 서로 각기 다른 3자리 수인지 판별한다.
   - 3자리 확인
   - 숫자 타입 확인
   - 1~9까지 범위 확인
   - 중복값 유무 확인
   - 입력값이 유효성이 부적합할 경우, IllegalArgumentException을 발생시킨 후 애플리케이션은 종료된다.
5. 입력값의 유효성이 적합할 경우, 사용자 입력값이 정답인지 판별하여 출력한다.
6. 사용자 입력값을 순회하여 정답과 비교한다.
7. 정답과 같은 자리수(위치)에 같은 값이면 “스트라이크” 처리한다.
8. 정답에 해당 숫자가 포함되어 있으면 “볼” 처리한다.
9. 정답에 해당하는 숫자가 없을 경우 “낫싱” 처리한다.
10. 사용자 입력값이 정답이 될 때까지 2~5번을 반복한다.
11. 사용자 입력값이 정답이 되면 해당 게임이 종료된다.
12. 해당 게임 종료 후, 사용자는 게임 재시작(1)과 게임 종료(2) 중 하나를 선택할 수 있다.
13. 게임 다시 시작을 선택할 경우, 1번 과정부터 다시 시작된다.
14. 게임 종료를 선택할 경우, 프로그램이 종료된다. 
