gsap.registerPlugin(ScrollTrigger);

// HERO ANIMATION

gsap.from(".hero-content > *", {
  y: 80,
  opacity: 0,
  duration: 1.2,
  stagger: 0.15,
  ease: "power4.out"
});

gsap.from(".hero-image", {
  scale: 0.7,
  opacity: 0,
  rotate: -8,
  duration: 1.5,
  ease: "power4.out"
});

// PARALLAX

gsap.to(".hero-image", {
  y: 120,
  scrollTrigger: {
    trigger: ".hero",
    start: "top top",
    end: "bottom top",
    scrub: true
  }
});

// STICKY IMAGE ZOOM

gsap.fromTo(".sticky-panel.right img",
{
  scale: 0.8,
  rotate: -6
},
{
  scale: 1,
  rotate: 0,
  scrollTrigger:{
    trigger: ".sticky-showcase",
    start: "top top",
    end: "bottom bottom",
    scrub: true
  }
});

// REVEAL

gsap.utils.toArray(".product-card, .gallery-card, .compare-image").forEach((el)=>{

  gsap.from(el,{
    y:120,
    opacity:0,
    duration:1.2,
    ease:"power4.out",
    scrollTrigger:{
      trigger:el,
      start:"top 85%"
    }
  });

});

// MAGNETIC EFFECT

document.querySelectorAll(".product-card").forEach(card=>{

  card.addEventListener("mousemove",(e)=>{

    const rect = card.getBoundingClientRect();

    const x = e.clientX - rect.left;
    const y = e.clientY - rect.top;

    const moveX = (x - rect.width / 2) / 20;
    const moveY = (y - rect.height / 2) / 20;

    gsap.to(card,{
      rotationY: moveX,
      rotationX: -moveY,
      transformPerspective:1000,
      ease:"power2.out",
      duration:0.5
    });

  });

  card.addEventListener("mouseleave",()=>{

    gsap.to(card,{
      rotationY:0,
      rotationX:0,
      duration:0.6,
      ease:"power3.out"
    });

  });

});

// HEADER BLUR

window.addEventListener("scroll",()=>{

  const header = document.querySelector(".header");

  if(window.scrollY > 50){
    header.style.background = "rgba(0,0,0,0.75)";
  }else{
    header.style.background = "rgba(0,0,0,0.45)";
  }

});
