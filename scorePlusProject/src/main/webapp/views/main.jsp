<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%@ include file="include/header.jsp" %>
<main>
  <section id="hero">
    <div class="hero-container">
      <div id="heroCarousel" data-bs-interval="5000" class="carousel slide carousel-fade" data-bs-ride="carousel">

        <ol class="carousel-indicators" id="hero-carousel-indicators"></ol>

        <div class="carousel-inner" role="listbox">

          <!-- Slide 1 -->
          <div class="carousel-item active" style="background-image: url(/scorePlusProject/static/img/slide/slide-1.jpg)">
            <div class="carousel-container">
              <div class="carousel-content">
                <h2 class="animate__animated animate__fadeInDown">Welcome to <span>SCOREPLUS</span></h2>
                <p class="animate__animated animate__fadeInUp">고객 지향적 서비스를 추구합니다.<br>수험자가 더 좋은 환경에서 응시할 수 있도록 음원을 제공하여 수험자에게 최적의 음질을 제공하려고 노력하고 있습니다.</p>
              </div>
            </div>
          </div>

          <!-- Slide 2 -->
          <div class="carousel-item" style="background-image: url(/scorePlusProject/static/img/slide/slide-2.jpg)">
            <div class="carousel-container">
              <div class="carousel-content">
                <h2 class="animate__animated animate__fadeInDown">Use <span>SCOREPLUS</span></h2>
                <p class="animate__animated animate__fadeInUp">대기업, 공기업, 외국계기업 등 다영한 부분의 기업에서 신입, 경력, 인턴 채용 및 인사고과, <br>해외파견근무자 선발 등 직원 영어능력평가를 위해 scoreplus를 다양하게 활용하고 있습니다.</p>
              </div>
            </div>
          </div>

        </div>
        
        <a class="carousel-control-prev" href="#heroCarousel" role="button" data-bs-slide="prev">
          <span class="carousel-control-prev-icon bi bi-chevron-left" aria-hidden="true"></span>
        </a>

        <a class="carousel-control-next" href="#heroCarousel" role="button" data-bs-slide="next">
          <span class="carousel-control-next-icon bi bi-chevron-right" aria-hidden="true"></span>
        </a>
        
      </div>
    </div>
  </section>
</main>
<%@ include file="include/footer.jsp" %>
</body>
</html>