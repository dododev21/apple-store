
gsap.registerPlugin(ScrollTrigger);

// HERO

gsap.from(".hero-content > *",{
  y:80,
  opacity:0,
  duration:1.2,
  stagger:.15,
  ease:"power4.out"
});

gsap.from(".hero-image img",{
  scale:.7,
  opacity:0,
  rotate:8,
  duration:1.5,
  ease:"power4.out"
});

// PARALLAX

gsap.to(".hero-image img",{
  y:100,
  scrollTrigger:{
    trigger:".hero",
    start:"top top",
    end:"bottom top",
    scrub:true
  }
});

// ULTRA ZOOM

gsap.fromTo(".ultra-image img",
{
  scale:.7,
  rotate:-6
},
{
  scale:1,
  rotate:0,
  scrollTrigger:{
    trigger:".ultra-section",
    start:"top top",
    end:"bottom bottom",
    scrub:true
  }
});

// REVEAL

gsap.utils.toArray(".watch-card, .feature-card, .health-card, .bands-content").forEach(el=>{

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

// 3D CARD EFFECT

document.querySelectorAll(".watch-card").forEach(card=>{

  card.addEventListener("mousemove",(e)=>{

    const rect = card.getBoundingClientRect();

    const x = e.clientX - rect.left;
    const y = e.clientY - rect.top;

    const moveX = (x - rect.width/2)/18;
    const moveY = (y - rect.height/2)/18;

    gsap.to(card,{
      rotationY:moveX,
      rotationX:-moveY,
      transformPerspective:1000,
      duration:.5
    });

  });

  card.addEventListener("mouseleave",()=>{

    gsap.to(card,{
      rotationY:0,
      rotationX:0,
      duration:.6
    });

  });

});

// HEADER EFFECT

window.addEventListener("scroll",()=>{

  const header = document.querySelector(".header");

  if(window.scrollY > 50){
    header.style.background = "rgba(0,0,0,.75)";
  }else{
    header.style.background = "rgba(0,0,0,.45)";
  }

});
