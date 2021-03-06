#pragma version(1)
#pragma rs java_package_name(newera.EliJ)

const static float3 grayscaleValues = {0.299f, 0.587f, 0.114f};

//MAINS
uchar4 __attribute__((kernel)) Grayscale(uchar4 in, uint32_t x, uint32_t y) {
  uchar grayscale = in.r * grayscaleValues.r +  in.g * grayscaleValues.g + in.b * grayscaleValues.b;
  uchar4 out;
  out.a = in.a;
  out.r = grayscale;
  out.g = grayscale;
  out.b = grayscale;
  return out;
}