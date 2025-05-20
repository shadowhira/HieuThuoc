@echo off
echo Running BaoCao unit tests...
cd FE
ng test --include=src/app/_service/baocaoservice.spec.ts,src/app/ptit/sys/thongke/thongke.component.spec.ts
echo Test execution completed.
pause
