FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"


SRC_URI += "file://0001-lpddr4-modify-size-6GB-to-2GB.patch;subdir=git \
            file://0002-lpddr4-set-timing.patch;subdir=git \
            file://0003-lpddr4-add-phy-clock-for-1860M.patch;subdir=git \
            file://0004-clock-add-clock-for-930MHz.patch;subdir=git \
            file://gpio-hog.cfg;subdir=git \
            file://0001-dtb-modify-ethernet-settings.patch;subdir=git \
            file://0002-eth-modify-phy-address.patch;subdir=git \
            file://default-fdt-file.cfg;subdir=git \
            "
