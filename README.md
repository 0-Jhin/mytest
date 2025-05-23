# 네트워크
---
## 네트워크 기초
> 네트워크란 노드와 링크가 연결되어 리소스를 공유하는 집합이다.
- 노드: 서버, 라우터, 스위치 등
- 링크: 유선, 무선
- \* 좋은 네트워크: 많은 처리량을 처리할 수 있으며 지연시간이 짧고 장애 빈도가 적으며 좋은 보안을 갖춤

### 처리량과 지연시간
#### 처리량
> 링크 내에서 성공적으로 전달 된 데이터의 양
- 얼마큼의 트래픽을 처리했는지
- 처리량은 트래픽, 대역폭, 에러, 하드웨어에 영향을 받는다.
- \* 트래픽: 흐르는 데이터의 양

#### 지연시간
> 요청이 처리되는 시간, 어떤 메세지가 두 장치 사이를 왕복하는데 걸린 시간
- 지연시간은 매체 타입, 패킷 크기, 라우터의 패킷 처리 시간에 영향을 받는다.

### 네트워크 토폴로지와 병목현상
#### 네트워크 토폴로지
- 트리 토폴로지
  - 계층형 토폴로지, 트리 형태
  - 노드의 추가, 삭제가 쉬움
  - 특정 노드에 트래픽이 집정될 때 하위 노드에 영향을 끼칠 수 있음
- 버스 토폴로지
  - 중앙 통신 회선 하나에 여러 개의 노드가 연결되어 공유
  - 근거리 통신망에서 사용
  - 설치 비용이 적고 신뢰성이 우수
  - 중앙 통신 호선에노드를 추가하거나 삭제하기 쉬움
  - <details> <summary>스푸핑</summary> LAN 상에서 송신부의 패킷을 송신과 관련 없는 다른 호스트에게 가지 않도록 하는 스위칭 기능을 마비시키거나 속여서 특정 노드에 해당 패킷이 오도록 처리하는 것 </details> 가능한 문제점
- 스타 토폴로지
  - 중앙에 있는 노드에 모두 연결된 네트워크 구성
  - 노드를 추가하거나 에러를 탐지하기 쉽고 패킷의 충돌 발생 가능성이 적다.
  - 중앙 노드에 장애 발생시 전체 네트워크를 사용할 수 없다.
  - 설치 비용이 고가이다.
- 링형 토폴로지
  - 각각의 노드가 양 옆의 두 노드와 연결하여 하나의 연속된 길을 통해 통신하는 망 구성 방식
  - 노드 수가 증가되어도 네트워크상의 손실이 거의 없고 충돌이 발생되는 가능성이 적고 노드의 고장 발결은 쉽게 찾을 수 있음
  - 네트워크 구성 변경이 어렵고 회선 장애가 발생하면 전체 네트워크에 영향을 크게 끼친다.
- 메시 토폴로지
  - 망형 토폴로지, 그물망처럼 연결
  - 한 단말 장치에 장애가 발생해도 여러 경로가 존재하여 네트워크를 계속 사용할 수 있음
  - 트래픽 분산 처리 가능
  - 노드의 추가가 어려움
  - 구축 비용과 운영 비용이 비쌈

#### 병목현상
> 전체 시스템의 성능이나 용량이 하나의 구성 요소로 인해 제한을 받는 현상
- 네트워크가 어떤 토폴로지를 갖는지, 또한 어떠한 경로로 이루어져 있는지 알아야 병목현상을 해셜할 수 있다.

---

## TCP/IP 4계층
### 계층 구조
OSI 7계층과 많이 비교한다.

#### 애플리케이션 계층
> FTP, HTTP, SSH, SMTP, DNS 등 응용 프로그램이 사용되는 프로토콜 계층이며 웹 서비스, 이메일 등 서비스를 실질적으로 사람들에게 제공하는 층이다.
- FTP: 장치와 장치 간의 파일을 전송하는데 사용되는 표준 통신 프로토콜
- SSH: 보안되지 않은 네트워크에서 네트워크 서비스를 안정하게 운영하기 위한 암호화 네트워크 프로토콜
- HTTP: WWW을 위한 데이터 통신의 기초이자 웹 사이트를 이용하는데 쓰는 프로토콜
- SMTP: 전자 메일 전송을 위한 인터넷 표준 통신 프로토콜
- DNS: 도메인 이름과 IP주소를 매핑해주는 서버

#### 전송 계층
> 송신자와 수신자를 연결하는 통신 서비스를 제공하며 연결 지향 데이터 스트림 지원, 신회성, 흐름 제어를 제공할 수 있으며 애플리케이션과 인터넷 계층 사이의 데이터가 전달 될 때 중계 역할을 한다.
- TCP: 패킷 사이의 순서를 보장하고 연결 지향 프로토콜을 사용해서 연결하여 신뢰성을 구축해서 수신 여부를 확인
  - 가상회선 패킷 방식: 각 패킷에 가상회선 식별자가 포함되어 모든 패킷을 전송하면 가상회선이 해제되고 패킷들은 전송된 순서대로 도착하는 방식
- UDP: 순서를 보장하지 않고 수신 여부를 확인하지 않으며 단순히 데이터만 준다.
  - 데이터 그램 패킷 교환 방식: 패킷이 독립적으로 이동하며 최적의 경로를 선택하여 가는데, 하나의 메세지에서 분할 된 여러 패킷은 서로 다른 경로로 전송될 수 있으며 도착한 순서가 다를 수 있다.

**TCP 연결 성립 과정**
  - 3-웨이 핸드 셰이크: 신뢰성 구축
    1. SYN 단계: 클라이언트는 서버에 클라이언트의 ISN을 담아 SYN을 보낸다 ISN은 새로운 TCP 연결의 첫 번째 패킷에 한당된 임의의 시퀀스 번호를 말한다.
    2. SYN + ACK 단계: 서버는 클라이언트의 SYN을 수신하고 서버의 ISN을 보내며 승인 번호로 클라이언트의 ISN+1을 보낸다.
    3. ACK 단계: 클라이언트는 서버의 ISN+1한 값인 승인 번호를 담아 ACK를 서버에 보낸다.

**TCP 연결 해제 과정**
- 4-웨이 핸드 셰이크
    1. 먼저 클라이언트가 연결을 닫으려고 할 때 FIN으로 설정된 세그먼트응 보냅니다. 그리고 클라이언트는 FIN_WAIT_1 상태로 들어가고 서버의 응답을 기다린다.
    2. 서버는 클라이언트로 ACK라는 승인 세그먼트를 보낸다. 그리고 CLOSE_WAIT 상태에 들어간다. 클라이언트가 세그먼트를 받으면 FIN_WAIT_2 상태가 된다.
    3. 서버는 ACK를 보내고 일정시간 이루헤 클라이언트에 FIN이라는 세그먼트를 보낸다.
    4. 클라이언트는 TIME_WAIT 상태가 되고 다시 서버로 ACK를 보내서 서버는 CLOSED 상태가 된다. 이후 클라이언트는 어느 정도의 시간을 대기한 후 연결이 닫히고 클라이언트와 서버의 모든 자원의 연결이 해제된다.
    > 지연 패킷이 발생할 경우를 대비하고 두 장치가 닫혔는지 확인하기 위해서 TIME_WAIT을 사용한다.

#### 인터넷 계층
> 장치로 부터 받은 네트워크 패킷을 IP주소로 지정된 목적지로 전송하기 위해 사용되는 계층이다. IP, ARP, ICMP 등이 있으며 패킷을 수신해야 할 상대의 주소를 저정하여 데이터를 전달한다.
- 무결성을 보장하지 않는다.
- 비 연결적

#### 링크 계층
> 실질적으로 데이터를 전달하며 장치간에 신호를 주고 받는 '규칙'을 정하는 계층이다.
- 네트워크 접근 계층
- 이더넷 프레임을 통해 에러 확인, 흐름 제어, 접근 제어를 담당하는 계층
- **전이중화 통신**
  - 양쪽 장치가 동시에 송수신 할 수 잇는 방식
  - 송신로와 수신로로 나눠서 데이터를 주고 받는다.
- **CSMA/CD**
  - 데이터를 보낸 이후 충돌이 발생한다면 일정시간 이후 재전송
  - 수신로와 송신로가 같아 충돌에 대비해야 했기 때문에
  - 반이중화 통신 중 하나이다.
- **반이중화 통신**
  - 동시에는 통신할 수 없으며 한 번에 한 방향만 통신할 수 있는 방식
  - 충돌 방지 시스템 필요
- **CSMA/CA**
  - 데이터를 보내기 전 일련의 과정으로 사전에 가능한 한 충돌을 방지한다.
    1. 사용중인 채널이 있다면 다른 채널을 감지하다 유후 상태인 채널을 발견한다
    2. 프레임 간 공간 시간인 IFS 시간만큼 기다립니다. IFS는 프레임의 우선수위를 정의할 때도 사용됩니다. IFS가 낮으면 우선순위가 높습니다.
    3. 프레임을 보내기 전 핸덤 상수를 기반으로 결정된 시간 만큼 기다린 뒤 프레임을 보냅니다. 프레임을 보낸 뒤 제대로 송신이 되었고 ACK 세그먼트를 받았다면 마친다
    4. 받지 못했다면 k = k+1을 하여 이 과정을 반복한다. k가 정해진 Kmax보다 커지면 해당 프레임 전송은 버린다.

---

## 네트워크 기기
### 네트워크 기기의 처리 범위
> 네트워크 기기는 계층별로 처리 범위를 나눌 수 있다.
- 상위 계층을 처리하는 기기는 하위 계층을 처리할 수 있다.

### 애플리케이션 계층 처리 기기
- L7 스위치(=로드밸런서): 서버의 부하를 분산하는 기기
> 클라이언트로 부터 오는 요청들을 뒤쪽의 여러 서버로 나누는 역할을 한다. 시스템이 처리할 수 있는 트래픽 증가를 목표로 한다.
  - URL, 서버, 캐시, 쿠키들을 기반으로 트래픽을 분산한다.
  - 바이러스, 불필요한 외부 데이터 등을 걸러내는 필터링 가능 또한 가지고 있으며 응용 프로그램 수준의 트래픽 모니터링 가능
- 스위치: 여러 장비를 연결하고 데이터 통신을 중재하며 목적지가 연결된 포트로만 전기 신호를 보내 데이터를 전송하는 기기
- 헬스 체크: 전송 주기와 재전송 횟수 등을 설정한 이후 반복적으로 서버에 요청을 보내는 것
  - TCP, HTTP 등 다양한 방법으로 요청을 보내며 이 요청이 정상적으로 이루어졌다면 정상적인 서버
- 로드밸런서를 이용한 서버 이중화: 로드밸런서의 대표기능 = 서버 이중화
  - 로드밸런서는 2대 이상의 서버를 기반으로 가상 IP를 제공하고 이를 기반으로 안정적인 서비스를 제공한다.

### 인터넷 계층 처리 기기
- 라우터: 여러 개의 네트워크를 연결, 분할, 구분시켜주는 역할을 한다.
  > 다른 네트워크에 존재하는 장치끼리 서로 데이터를 주고 받을 때 패킷 소모를 최소화 하고 경로를 최적화하여 최소 경로로 패킷을 포워딩 한다.
- L3 스위치: L2 스위치 기능과 라우팅 기능을 갖춘 장치 (=라우터)
  - 하드웨어 기반의 라우팅 담당 장치
  - 
### 데이터 링크 처리 기기
- L2 스위치: MAC 주소를 MAC 주소 테이블로 관리하며 연결된 장치로 부터 패킷이 왔을 때 패킷 전송을 담당한다.
  - IP주소는 이해하지 못한다.
  - 단순히 패킷의 MAC주소를 읽어 스위칭한다.
  - 목적지가 MAC 주소 테이블에 없다면 전체 포트에 전달한다.
  - MAC 주소 테이블의 주소를 일정 시간 이후에 삭제하는 기능도 있다.
- 브리지: 두 개의 근거리 통신방을 상호 접속 할 수 있도록 하는 통신만 연결 장치, 통신망 범위를 확장하고 서로 다른 LAN 등으로 이루어진 하나의 통신망을 구축한다.

### 물리 계층 처리 기기
- NIC: LAN카드, 2대 이상의 컴퓨터 네트워크를 구성하는데 사용된다.
- 리피터: 약해진 신호 정보를 증폭하여 패킷이 더 멀리 갈 수 있게 한다.
- AP: 패킷을 복사하는 기기

---
 
## IP주소
### ARP
> 컴퓨터 간의 통신은 IP주소에서 ARP를 통해 MAC주소를 찾아 MAC 주소를 기반으로 통신한다
- ARP란 IP 주소로부터 MAC 주소를 구하는 IP와 MAC 주소의 다리 역할을 하는 프로토콜이다.
- ARP를 통해 가상 주소인 IP 주소를 실제 주소인 MAC 주소로 변환합니다. 이와 반대로 RARP를 통해 실제 주소인 MAC 주소를 가상의 주소인 IP 주소로 변환하기도 한다.
- 브로드캐스트: 송신 호스트가 전송한 데이터가 네트워크에 연결된 모든 호스트에게 전송되는 방식
- 유니캐스트: 고유 주소로 식별된 하나의 네트워크 목적지에 1:1로 데이터를 전송하는 방식

### 홉 바이 홉
> IP 주소를 통해 통신하는 과정, 통신 장치에 있는 라우팅 테이블이 IP 주소를 통해 시작 주소부터 시작하여 다음 IP로 계속 이동해서 라우팅 과정을 거쳐 패킷이 최종 목적지 까지 도달하는 통신을 말한다.
- 라우팅: IP 주소를 찾아가는 과정
- 라우팅 테이블: 라우터에 들어가있는 목적지 정보들과 그 목적지로 가기 위한 방법이 들어있는 리스트, 라우팅 테이블에는 게이트 웨이와 모든 목적지에 도달하기 위해 가져야할 다음 라우터의 정보를 가지고 있다.
- 게이트웨이: 서로다른 통신망, 프로토콜을 사용하는 네트워크 간의 통신을 가능하게 하는 관문 역할을 하는 컴퓨턴 소프트웨어이다. 서로 다른 네트워크상의 통신 프로토콜을 변환해주는 역할을 한다.

### IP 주소 체계
> 클래스기반 - 사용하는 주소보다 버리는 주소가 많다는 단점을 해결하기 위해 DHCP와 IPv6, NAT이 나타났다.
- DHCP: IP주소 및 기타 통신 매개 변수를 자동으로 할당하기 위한 네트워크 관리 프로토콜이다. 이 기술로 네트워크 장치의 IP 주소를 수종으로 설정할 필요 없이 인터넷에 접속할 때마다 자동으로 할당이 가능하다.
- NAT: 패킷이 라우팅 장치를 통해 전송되는 동안 패킷의 IP 주소를 정보를 수정하여 다른 주소로 매핑하는 방법이다.
  - IPv4의 문제를 해결하기 의해 NAT으로 공인 IP와 사설 IP로 나누어서 많은 주소를 처리한다. NAT을 가능하게 하는 소프트 웨어로 ICS, RRAS, Netfliter가 있다.
  - 사설 IP -> 공인 IP, 공인 IP -> 사설 IP
  - NAT은 여러 대의 호스트가 하나의 공인 IP 주소를 사용해 인터넷에 접속하기 위해 쓴다.
  - 내부 네트워크에서 사용하는 IP 주소와 외부에서 사용하는 IP 주소를 다르게 유지할 수 있어 내부 네트워크 보안이 가능하다.
  - 여러명이 동시에 인터넷에 접속하게 되므로 실제 접속하는 호스트 숫자에 따라 접속 속도가 느려질 수 있다.

---

## HTTP
### HTTP/1.0
> 기본적으로 한 연결당 하나의 요청을 처리하도록 설계되어있다. -> RTT증가
- 서버로부터 파일을 가져올 떄마다 TCP의 3-웨이 핸드셰이크를 열어야 해서 RTT가 증가한다.
- **RTT**: 패킷이 목적지에 도달하고 나서 출발지로 돌아오기 까지 걸리는 시간, 패킷 왕복 시간

### HTTP/1.1
> 매번 TCP 연결하는 것이 아니라 한 번 TCP 초기화를 한 이후에 kepp-alive라는 옵션으로 여러 개의 파일을 송수신 할 수 있게 바뀌었다.
- 한번 3-웨이 핸드 셰이크가 발생하면 이후로는 발생하지 않는다
- 리소스 개수에 비례해서 대기시간이 길어진다.

### HTTP/2
> 지연시간을 줄이고 응답시간을 더 빠르게 할 수 있으며 멀티플렉싱, 헤더 압축, 서버 푸시, 요청의 우선순위 처리를 지원하는 프로토콜.
- 멀티플렉싱: 여러 개의 스트림을 사용하여 송수신 하는 것
  - 특정 스트림의 패킷이 손실되어도 해당 스트림에만 영향을 끼치고 나머지 스트림은 멀쩡하게 동작한다.
  - 어플리케이션에서 받아온 메세지는 독립된 프레임으로 조각내어 서로 송수신한 이후 다시 조립하여 주고받는다.
  - 스트림: 시간이 지남에 따라 사용할 수 있게 되는 일련의 데이터 요소를 가리키는 데이터 흐름
- 허프만 코딩: 문자열을 문자 단위로 쪼개 빈도수를 세어 빈도가 높은 정보는 적은 비트, 빈도가 낮은 정보는 비트 수를 많이 사용한다.
  - 전체 데이터 표현에 필요한 비트양이 줄어든다.
- 서버 푸시: 클라이언트 요청 없이도 서버가 리소르를 푸시할 수 있는 기능

### HTTPS
> 애플리케이션 계층과 전송 계층 사이에 신뢰 계층인 SSL/TLS 계층을 넣은 신뢰할 수 있는 HTTP 요청
#### SSL/TLS
- SSL/TLS: 전송계층에서 보안을 제공하는 프로토콜이다. 클라이언트와 서버가 통신할 때 SSL/TLS를 통해 제 3자가 메세지를 도청하거나 변조하지 못하도록 한다.
  - 인터센터를 방지할 수 있다.
  - SSL/TLS는 보안 세션을 기반으로 데이터를 암호화하며 보안 세션이 만들어질 때 인증 메커니즘, 키 교환 암호화 알고리즘, 헤싱 알고리즘이 사용된다.
  - 보안세션: 보안이 시작되고 끝나는 동안 유지되는 세션을 말하고, SSL/TLS는 핸드셰이크를 보안 세션을 생성하고 이를 기반으로 상태 정보 등을 공유한다.
  - 세션: 운영체제가 어떠한 사용자로부터 자신의 자산 이용을 허락하는 일정 기간을 뜻한다.
클라이언트에서 사이퍼 슈트를 서버에 전달하면 서버는 받은 사이퍼 슈트의 암호화 알고리즘 리스트를 제공할 수 있는지 확인한다. 제공할 수 있다면 서버에서 클라이언트오 인증서를 보내는 인증 메커니즘이 시작되고 이후 해싱 알고리즘 등으로 암호화된 데이터의 송수신이 시작된다.
- 사이퍼 슈트: 프로토콜, AEAD 사이퍼 모드, 해싱 알고리즘이 나열된 규약이다.
  - 인증 매커니즘: CA에서 발급한 인증서 기반으로 이루어진다. 인증서는 안전한 연결을 ㄹ하는데 있어 필요한 공개키를 클라이언트에 제공하고 사죵자가 접속한 서버가 신뢰할 수 있는 서버임을 보장한다.
  - 암호화 알고리즘: 대수곡선 기반의 ECDHE 또는 모듈식의 DHE를 사용한다. 둘다 디피-헬만 방식을 근간으로 작성되었다.
    - 디피-헬만 키 교환 알고리즘: y = g^x mod p
    - g와 x, p를 안다면 y를 구하기 쉽지만 g와 y, p만 안다면 x를 구하기는 어렵다.
  - 해싱 알고리즘: 데이터를 추정하기 힘든 더 작고, 섞여있는 조각으로 만드는 알고리즘

#### SEO
> 서비스를 운영한다면 SEO 관리는 필수이다. 이를 위한 방법으로는 캐노니컬 설정, 메타설정, 페이지 속도 개선, 사이트 맵 관리 등이 있다.
- 캐노니컬 설정: 사이트 link에 캐노니컬 설정
- 메타 설정: html 파일의 메타 설정
- 페이지 속도 개선
- 사이트맵 관리: .xml 파일 관리

#### HTTPS 구축 방법
1. 직접 CA에서 구매한 인증키를 기반으로 HTTPS 서비스 구축하기
2. 서버 앞단에 HTTPS를 제공하는 로드밸런서 두기
3. 서버 앞단에 HTTPS를 제공하는 CDN 두기 

### HTTP/3
> HTTP/3는 QUIC 계층 위에서 돌아가며 UDP 기반으로 돌아간다.
- 초기 연결시간 감소: TCP를 사용하지 않아 번거로운 3-웨이 핸드셰이크과정을 거치지 않는다.
  - ->QUIC는 첫 연결 설정에 1-RTT만 소요된다.
  - 순방향 오류 수정 매커니즘이 적둉되어있다.
  - -> 전송한 패킷이 손실되었다면 수신 측에서 에러를 검출하고 수정하는 방식
  - -> 열악한 네트워크 환경 속에서도 낮은 패킷 손실률을 자랑한다.
