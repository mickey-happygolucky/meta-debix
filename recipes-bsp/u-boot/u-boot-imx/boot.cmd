setenv mmcargs 'setenv bootargs ${jh_clk} ${mcore_clk} console=${console} root=${mmcroot}'
fatload mmc 1 ${kernel_addr_r} ${image}
fatload mmc 1 ${fdt_addr_r} ${fdtfile}
run mmcargs
booti ${loadaddr} - ${fdt_addr_r}
