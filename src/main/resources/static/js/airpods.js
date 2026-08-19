
gsap.registerPlugin(ScrollTrigger);

gsap.from(".hero-content > *",{
y:80,
opacity:0,
duration:1.2,
stagger:.15
});

gsap.from(".hero-image img",{
scale:.7,
opacity:0,
rotate:8,
duration:1.5
});

gsap.utils.toArray(".product-card, .feature-card, .gallery-card, .icon-card").forEach(el=>{

gsap.from(el,{
y:120,
opacity:0,
duration:1.2,
scrollTrigger:{
trigger:el,
start:"top 85%"
}
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
