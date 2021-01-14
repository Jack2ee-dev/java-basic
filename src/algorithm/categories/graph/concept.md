# 그래프 이론

## 그래프란?

그래프는 정점과 간선으로 이루어진 자료구조입니다. 정확히는 정점(vertex 혹은 node)
간의 관계를 표현하는 조직도라고 볼 수 있습니다. 그런 점에서 트리도 그래프의 일종으로 볼 수 있습니다. 다만 트리와 달리 그래프는 정점마다 간선(edge)이 없을 수도 있으며
루트 노드, 부모와 자식이라는 개념이 없습니다.

## 그래프 구성

- 정점(vertices): 노드(node)라고도 하며 데이터가 저장됩니다.
- 간선(edge): 링크(arcs)라고도 하며 노드간의 관계(연결여부, 가중치 등)를 나타냅니다.
- 인접정점(adjacent vertex): 간선에 의해 연결된 정점입니다.
- 단순경로(simple path): 경로 중 반복되는 정점이 없는 경로입니다.
- 차수(degree): 무방향 그래프에서 하나의 정점에 인접한 정점의 수
- 진출 차수(out-degree): 방향 그래프에서 사용되는 용어로 한 노드에서 외부로 향하는 간선의 수를 뜻합니다.
- 진입 차수(in-degree): 방향 그래프에서 사용되는 용어로 외부 노드에서 들어오는 간선의 수를 뜻합니다.

## 그래프 구현 방법

그래프를 구현하는 방법에는 **인접행렬**(adjacent matrix)와 **인접리스트**(adjacent list)가 있습니다. 각각은 상반된 장단점을 가지고 있는데 대부분
인접리스트 형식을 사용합니다.

### 인접행렬(adjacent matrix)

- **정의**: 인접행렬은 그래프의 노드를 2차원 배열로 만든 것입니다. 노드에 다른 노드들이 인접 정점이면(adjacent)
  1, 아니면 (0 혹은 무한)을 넣어줍니다.

- **장점**
    - 2차원 배열 안에 모든 정점들의 간선 정보를 담기 때문에 배열의 위치를 확인하면 두 점의 연결 정보를 조회할 때 O(1)의 시간 복잡도면 가능합니다.
    - 구현이 비교적 간편합니다.

- **단점**
    - 모든 정점의 정보를 저장하기 위해 O(V^2)의 공간 복잡도가 소용됩니다.
    - 모든 정점의 연결 정보를 조회하기 위해 O(V^2)의 시간 복잡도가 소요됩니다.

### 인접리스트(adjacent list)

- **정의**: 인접리스트는 그래프의 노드들을 리스트로 표현한 것입니다. 주로 정점의 리스트 배열을 만들어 관계를 설정해줍니다.

- **장점**
    - 모든 정점의 연결 정보를 탐색할 때 O(V+E)의 시간이면 가능합니다.
    - 모든 정점의 정보를 저장하기 위해 O(V+E)의 공간이면 됩니다.

- **단점**
    - 특정 정점들 간의 연결정보를 확인하기 위해서는 O(V+E)의 시간이 소요됩니다.
    - 구현이 비교적 어렵습니다.

### 그래프의 유형

- 무방향그래프: 무방향 그래프는 두 정점을 연결하는 간선에 방향이 없는 그래프입니다.
- 방향그래프: 방향 그래프는 두 정점을 연결하는 간선에 방향이 있는 그래프입니다. 간선의 방향으로만 이동 가능합니다.
- 가중치그래프: 가중치 그래프는 두 정점을 이동할 때 비용이 드는 그래프입니다.
- 완전그래프: 완전 그래프는 모든 정점이 간선으로 연결되어 있는 그래프입니다.

## 그래프의 탐색

첫 정점에서부터 그래프에 존재하는 모든 정점들을 한번씩 방문하는 것을 그래프의 탐색이라고 합니다. 그래프 탐색의 방법은 **깊이 우선 탐색(Depth First Search)**
과 **너비 우선 탐색(Breadth First Search)**가 있습니다.


    