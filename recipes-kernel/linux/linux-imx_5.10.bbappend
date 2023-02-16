KERNEL_SRC_debix-a ?= "git://github.com/debix-tech/linux;protocol=https"
SRCBRANCH_debix-a = "debix"
SRCREV_debix-a = "f924d76e63c153f58206425d31f88c5771caeb80"

SRC_URI_append_debix-a = " file://0001-linux-imx-fix-tar-option.patch"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

