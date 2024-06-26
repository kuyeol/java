Alice와 Bob은 각각 HackerRank에 대해 하나의 문제를 만들었습니다. 검토자는 문제의 명확성 , 독창성 , 난이도의 세 가지 범주에 대해 1 부터 100 까지의 점수를 부여하여 두 가지 과제를 평가합니다 .

Alice의 챌린지 등급은 세 쌍 a = (a[0], a[1], a[2]) 이고 Bob의 도전 등급은 세 쌍 b = (b[0], b[1], b 입니다. [2]) .

임무는 a[0] 과 b[0] , a[1] 과 b[1] , a[2] 와 b[2] 를 비교하여 비교 지점을 찾는 것입니다 .

## 필요 객체

> [!NOTE]
> Useful information that users should know, even when skimming content.
>

앨리스,밥의 점수 합계
```java
int alice_score
int bob_score
```

두사람의 합계 점수 배열

```java
List<Integer,Integer> slist = new 
```
a[i] > b[i] 이면 Alice는 1 점을 얻습니다

```java
if(a[i]>b[i]) return alice_score+=1;
```

a[i] < b[i] 이면 Bob에게 1 점이 부여됩니다 .
a[i] = b[i] 이면 두 사람 모두 점수를 받지 못합니다.
비교 포인트는 개인이 획득한 총 포인트입니다.

a 와 b 가 주어지면 각각의 비교 지점을 결정합니다.

예

a = [1, 2, 3]
b = [3, 2, 1]
요소 *0*의 경우 a[0] 때문에 Bob에게 점수가 부여됩니다 .
동일한 요소 a[1] 및 b[1] 의 경우 점수가 획득되지 않습니다.
마지막으로 요소 2 의 경우 a[2] > b[2] 이므로 Alice는 포인트를 받습니다.
반환 배열은 [1, 1] 이며 Alice의 점수가 첫 번째이고 Bob의 점수가 두 번째입니다.

기능 설명

아래 편집기에서 CompareTriplets 함수를 완성하세요 .

CompareTriplets에는 다음 매개변수가 있습니다.

int a[3] : Alice의 도전 등급
int b[3] : Bob의 도전 등급
반품

int[2] : Alice의 점수는 첫 번째 위치에 있고 Bob의 점수는 두 번째 위치에 있습니다.
입력 형식

첫 번째 줄에는 공백으로 구분된 3개의 정수 a[0] , a[1] 및 a[2] 가 포함되어 있으며 각각의 값은 세 쌍 a 입니다 .
두 번째 줄에는 공백으로 구분된 3개의 정수 b[0] , b[1] 및 b[2] 가 포함되어 있으며 각 값은 삼중항으로 표시됩니다.

제약

1 ≤ a[i] ≤ 100
1 ≤ b[i] ≤ 100
