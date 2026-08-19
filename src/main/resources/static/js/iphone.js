
gsap.registerPlugin(ScrollTrigger);

// HERO

gsap.from(".hero-left > *",{
  y:80,
  opacity:0,
  duration:1.2,
  stagger:.15,
  ease:"power4.out"
});

gsap.from(".hero-phone",{
  scale:.7,
  opacity:0,
  rotate:10,
  duration:1.5,
  ease:"power4.out"
});

// PARALLAX

gsap.to(".hero-phone",{
  y:120,
  scrollTrigger:{
    trigger:".hero",
    start:"top top",
    end:"bottom top",
    scrub:true
  }
});

// STICKY SCALE

gsap.fromTo(".video-card img",
{
  scale:.75,
  rotate:-5
},
{
  scale:1,
  rotate:0,
  scrollTrigger:{
    trigger:".video-section",
    start:"top top",
    end:"bottom bottom",
    scrub:true
  }
});

// REVEAL

gsap.utils.toArray(".model-card, .feature-card, .ios-content").forEach(el=>{

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

// 3D HOVER

document.querySelectorAll(".model-card").forEach(card=>{

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

window.addEventListener("scroll",()=>{

  const header = document.querySelector(".header");

  if(window.scrollY > 50){
    header.style.background = "rgba(0,0,0,.75)";
  }else{
    header.style.background = "rgba(0,0,0,.45)";
  }

});
